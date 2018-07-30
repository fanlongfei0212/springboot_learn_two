package com.yinghuaicc.stars.controller.business.common.test.multi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/22 下午3:44
 * @Description:
 * @Modified:
 */
public class ListTestDTO {

    List<Rental> rentals = new ArrayList<Rental>();

    List<Property> properties = new ArrayList<Property>();;

    List<Decorate> decorates = new ArrayList<Decorate>();;

    List<Agent> agents = new ArrayList<Agent>();;

    List<Labour> labour = new ArrayList<Labour>();;

    public List<Rental> getRentals() {
        return rentals;
    }

    public ListTestDTO setRentals(List<Rental> rentals) {
        this.rentals = rentals;
        return this;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public ListTestDTO setProperties(List<Property> properties) {
        this.properties = properties;
        return this;
    }

    public List<Decorate> getDecorates() {
        return decorates;
    }

    public ListTestDTO setDecorates(List<Decorate> decorates) {
        this.decorates = decorates;
        return this;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public ListTestDTO setAgents(List<Agent> agents) {
        this.agents = agents;
        return this;
    }

    public List<Labour> getLabour() {
        return labour;
    }

    public ListTestDTO setLabour(List<Labour> labour) {
        this.labour = labour;
        return this;
    }
}
