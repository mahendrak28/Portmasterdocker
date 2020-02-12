package com.portmaster.entity;

import java.io.Serializable;
import java.util.List;

public class PortStaticWrapper implements Serializable {
    private List<PortStaticAttribute> portStaticAttributes;

    public PortStaticWrapper(List<PortStaticAttribute> portStaticAttributes) {
        this.portStaticAttributes = portStaticAttributes;
    }

    public List<PortStaticAttribute> getPortStaticAttributes() {
        return portStaticAttributes;
    }

    public void setPortStaticAttributes(List<PortStaticAttribute> portStaticAttributes) {
        this.portStaticAttributes = portStaticAttributes;
    }
}
