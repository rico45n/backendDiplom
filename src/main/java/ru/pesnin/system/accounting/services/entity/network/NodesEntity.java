package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;


@Entity
@Data
@Table(schema = "network", name = "Nodes")
@NoArgsConstructor
public class NodesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nodes")
    private Integer idNodes;

    @ManyToOne
    @JoinColumn(name = "user_otv",referencedColumnName = "user_id")
    private UsersEntity userOtv;

    @Column(name = "name_nodes")
    private String nameNodes;

}
