package ru.pesnin.system.accounting.integration.dto.network;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import ru.pesnin.system.accounting.services.entity.network.Pool_address_Domain;


import java.util.Date;

@Data
public class Pool_address_DTO {

    private Integer id_pool_address;
    private String name_pool;
    private String ip_addres_start;
    private String ip_addres_end;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date date_reg ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date date_old;
    private String user_old;
    private Integer id_user_old;
    private String user_reg;
    private Integer id_user_reg;

    private Integer id_status;
    private String name_status;

    public Pool_address_DTO() {
    }

    public Pool_address_DTO(Pool_address_Domain pool) {
        this.id_pool_address = pool.getId_pool_address();
        this.name_pool = pool.getName_pool();
        this.ip_addres_start = pool.getIp_addres_start();
        this.ip_addres_end = pool.getIp_addres_end();
        this.date_reg = pool.getDate_reg();
        this.date_old = pool.getDate_old();
        this.user_old = pool.getId_user_old().getFioUser();
        this.user_reg = pool.getId_user_reg().getFioUser();
        this.id_status = pool.getIs_status().getId_status();
        this.name_status = pool.getIs_status().getName_status();
        this.id_user_old = pool.getId_user_old().getUser_id();
        this.id_user_old = pool.getId_user_reg().getUser_id();
    }

    public Integer getId_pool_address() {
        return id_pool_address;
    }

    public void setId_pool_address(Integer id_pool_address) {
        this.id_pool_address = id_pool_address;
    }

    public String getName_pool() {
        return name_pool;
    }

    public void setName_pool(String name_pool) {
        this.name_pool = name_pool;
    }

    public String getIp_addres_start() {
        return ip_addres_start;
    }

    public void setIp_addres_start(String ip_addres_start) {
        this.ip_addres_start = ip_addres_start;
    }

    public String getIp_addres_end() {
        return ip_addres_end;
    }

    public void setIp_addres_end(String ip_addres_end) {
        this.ip_addres_end = ip_addres_end;
    }

    public Date getDate_reg() {
        return date_reg;
    }

    public void setDate_reg(Date date_reg) {
        this.date_reg = date_reg;
    }

    public Date getDate_old() {
        return date_old;
    }

    public void setDate_old(Date date_old) {
        this.date_old = date_old;
    }

    public String getUser_old() {
        return user_old;
    }

    public void setUser_old(String user_old) {
        this.user_old = user_old;
    }

    public String getUser_reg() {
        return user_reg;
    }

    public void setUser_reg(String user_reg) {
        this.user_reg = user_reg;
    }

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

    public String getName_status() {
        return name_status;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }

    public Integer getId_user_old() {
        return id_user_old;
    }

    public void setId_user_old(Integer id_user_old) {
        this.id_user_old = id_user_old;
    }

    @Override
    public String toString() {
        return "Pool_address_DTO{" +
                "id_pool_address=" + id_pool_address +
                ", name_pool='" + name_pool + '\'' +
                ", ip_addres_start='" + ip_addres_start + '\'' +
                ", ip_addres_end='" + ip_addres_end + '\'' +
                ", date_reg=" + date_reg +
                ", date_old=" + date_old +
                ", user_old='" + user_old + '\'' +
                ", id_user_old=" + id_user_old +
                ", user_reg='" + user_reg + '\'' +
                ", id_user_reg=" + id_user_reg +
                ", id_status=" + id_status +
                ", name_status='" + name_status + '\'' +
                '}';
    }

    public Integer getId_user_reg() {
        return id_user_reg;
    }

    public void setId_user_reg(Integer id_user_reg) {
        this.id_user_reg = id_user_reg;
    }
}

