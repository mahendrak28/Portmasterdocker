package com.portmaster.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PortEffAttribute")
@Table(name = "tbl_eff_dated_attribute")
public class PortEffAttribute {

    @Id
    @Column(name = "attribute_id")
    private int attribute_id;


    @ManyToOne(targetEntity = PortStaticAttribute.class)
    @JoinColumn(name="port_Id",referencedColumnName="port_Id")
    PortStaticAttribute portStaticAttribute;

      public PortStaticAttribute getPortStaticAttribute() {
        return portStaticAttribute;
            }
    public void setPortStaticAttribute(PortStaticAttribute portStaticAttribute) {
        this.portStaticAttribute = portStaticAttribute;
    }

    public PortEffAttribute() {
    }

   // private String port_Id;

    private String attribute_name;
    private String attribute_value;
    private String attribute_start_date;
    private String attribute_end_date;
    private String attribute_category;
    private String last_update_status_user;
    private Date last_update_status_date;

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

    public int getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(int id) {
        this.attribute_id = id;
    }

 /*  public String getPort_id() {
        return port_Id;
    }

    public void setPort_id(String port_id) {
        this.port_Id = port_id;
    }
*/
    public String getAttribute_name() {
        return attribute_name;
    }

    public void setAttribute_name(String attribute_name) {
        this.attribute_name = attribute_name;
    }

    public String getAttribute_value() {
        return attribute_value;
    }

    public void setAttribute_value(String attribute_value) {
        this.attribute_value = attribute_value;
    }

    public String getAttribute_start_date() {
        return attribute_start_date;
    }

    public void setAttribute_start_date(String attribute_start_date) {
        this.attribute_start_date = attribute_start_date;
    }

    public String getAttribute_end_date() {
        return attribute_end_date;
    }

    public void setAttribute_end_date(String attribute_end_date) {
        this.attribute_end_date = attribute_end_date;
    }

  public String getAttribute_category() {
        return attribute_category;
    }

    public void setAttribute_category(String attribute_category) {
        this.attribute_category = attribute_category;
    }

    @Override
    public String toString() {
        return "PortEffAttribute{" +
                "id=" + attribute_id +
            //  ", port_id='" + port_Id + '\'' +
                ", attribute_name='" + attribute_name + '\'' +
                ", attribute_value='" + attribute_value + '\'' +
                ", attribute_start_date='" + attribute_start_date + '\'' +
                ", attribute_end_date='" + attribute_end_date + '\'' +
                ", attribute_category='" + attribute_category + '\'' +
                '}';
    }
}

