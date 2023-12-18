package org.example._12_12_23;

public class Main {
//    Создайте интерфейс Playable с методами play() и stop(). Затем создайте класс AudioPlayer, который реализует интерфейс Playable.
//    Создайте еще один интерфейс Recordable с методами record() и stopRecording().
//    Создайте класс AudioRecorder, который реализует оба интерфейса. В методе main создайте объекты AudioPlayer и AudioRecorder
//    и продемонстрируйте их работу.
public static void main(String[] args) {
    AudioPlayer player = new AudioPlayer();
player.play("hella");

    System.out.println(player.getCurrentTrack());

    AudioRecorder recorder = new AudioRecorder();
    recorder.record();
    recorder.play("hell8");
    System.out.println(recorder.getCurrentTrack());
}
}
