package org.example._2023._12_12_23;

class AudioPlayer implements Playable{
    String trackName;

    @Override
    public void play(String trackName) {
        this.trackName = trackName;

    }

    @Override
    public void stop() {
        trackName="";
        System.out.println("No track playing now!");
    }

    @Override
    public String getCurrentTrack() {
        return trackName;
    }
}
