package com.example.muhammetmucahit.accessingfolderandlist;

/**
 * Created by Muhammet Mucahit on 8/18/2017.
 */

public class FileEx {
    String name;
    String path;
    String extension;
    Boolean isFolder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Boolean getFolder() {
        return isFolder;
    }

    public void setFolder(Boolean folder) {
        isFolder = folder;
    }
}
