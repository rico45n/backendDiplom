package ru.pesnin.system.accounting.services.entity.network;

import lombok.Data;
import jakarta.persistence.*;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;


@Entity
@Data
@Table(schema = "network", name = "Nodes")
public class NodesDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nodes;

    @ManyToOne
    @JoinColumn(name = "user_otv",referencedColumnName = "user_id")
    private UsersDomain user_otv;

    private String name_nodes;


    public NodesDomain() {
    }

    public void setId_nodes(Integer id_nodes) {
        this.id_nodes = id_nodes;
    }

    public UsersDomain getUser_otv() {
        return user_otv;
    }

    public void setUser_otv(UsersDomain user_otv) {
        this.user_otv = user_otv;
    }

    public String getName_nodes() {
        return name_nodes;
    }

    public void setName_nodes(String name_nodes) {
        this.name_nodes = name_nodes;
    }

    public Integer getId_nodes() {
        return id_nodes;
    }
}
