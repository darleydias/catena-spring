package com.github.darleydias.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.github.darleydias.domain.entity.Comarca;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface Comarcas extends JpaRepository<Comarca,Integer> {
//    @Query(value="select c from Comarca c where c.nome like :nome ")
//    List<Comarca> encontrarPorNome(@Param("nome") String nome);

    @Query(value="select * from tb_comarca c  where c.coma_nome like '%:com_nome%' ",nativeQuery = true)
    List<Comarca> encontrarPorNome(@Param("nome") String nome);

    @Query("delete from Comarca c where c.nome = :nome")
    // Como se trata de uma transação que modifica a base tenho que colocar a anotation Modifying:
    @Modifying
    void deleteByNome(String nome);


    Boolean existsByNome(String nome);
    @Query("select c from Comarca c left join fetch c.promotores where c.id = :id ")
    Comarca findComarcaFetchPromotores(@Param("id") Integer id);
}
