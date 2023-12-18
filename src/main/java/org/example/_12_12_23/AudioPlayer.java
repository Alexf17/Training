package org.example._12_12_23;

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
