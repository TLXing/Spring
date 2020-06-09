package com.dev.test;

public class Tree {

    public String id;
    public String directoryName;
    public String parentId;
    public int Depth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getDepth() {
        return Depth;
    }

    public void setDepth(int depth) {
        Depth = depth;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", directoryName='" + directoryName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", Depth=" + Depth +
                '}';
    }
}
