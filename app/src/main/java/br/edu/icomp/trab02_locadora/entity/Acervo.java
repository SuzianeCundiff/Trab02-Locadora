package br.edu.icomp.trab02_locadora.entity;

import java.util.ArrayList;

/**
 * @author Suziane Cundiff
 *
 */
public class Acervo {
    private ArrayList<Audio> audios;
    private ArrayList<Video> videos;

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }


}