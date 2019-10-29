package com.kpi.senin.lab1.model;

import java.util.Objects;

public class EntryModel {
    private String name;
    private Integer count;

    public EntryModel(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryModel that = (EntryModel) o;
        return count == that.count &&
                Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "EntryModel{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }
}
