package com.portmaster.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "PortStaticAttribute")
@Table(name = "tbl_static_attribute")
public class PortStaticAttribute implements Serializable {

    @Id
    @Column(name="ID")
    private int id;


    @Column(name = "port_Id", unique = true, nullable = false)
    private String port_Id;

    private String port_name;


    private int port_status;
    private String port_summary_flag;
    private String last_update_status_user;
    private Date last_update_status_date;

    public PortStaticAttribute() {
    }



    public PortStaticAttribute(int id, String port_Id, String port_name, int port_status, String port_summary_flag, String last_update_status_user, Date last_update_status_date) {
        this.id = id;
        this.port_Id = port_Id;
        this.port_name = port_name;
        this.port_status = port_status;
        this.port_summary_flag = port_summary_flag;
        this.last_update_status_user = last_update_status_user;
        this.last_update_status_date = last_update_status_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPort_Id() {
        return port_Id;
    }

    public void setPort_Id(String port_Id) {
        this.port_Id = port_Id;
    }

    public String getPort_name() {
        return port_name;
    }

    public void setPort_name(String port_name) {
        this.port_name = port_name;
    }

    public int getPort_status() {
        return port_status;
    }

    public void setPort_status(int port_status) {
        this.port_status = port_status;
    }

    public String getPort_summary_flag() {
        return port_summary_flag;
    }

    public void setPort_summary_flag(String port_summary_flag) {
        this.port_summary_flag = port_summary_flag;
    }

    public String getLast_update_status_user() {
        return last_update_status_user;
    }

    public void setLast_update_status_user(String last_update_status_user) {
        this.last_update_status_user = last_update_status_user;
    }

    public Date getLast_update_status_date() {
        return last_update_status_date;
    }

    public void setLast_update_status_date(Date last_update_status_date) {
        this.last_update_status_date = last_update_status_date;
    }

    @Override
    public String toString() {
        return "PortStaticAttribute{" +
                "id=" + id +
                ", port_Id='" + port_Id + '\'' +
                ", port_name='" + port_name + '\'' +
                ", port_status=" + port_status +
                ", port_summary_flag='" + port_summary_flag + '\'' +
                ", last_update_status_user='" + last_update_status_user + '\'' +
                ", last_update_status_date=" + last_update_status_date +
                '}';
    }



}
