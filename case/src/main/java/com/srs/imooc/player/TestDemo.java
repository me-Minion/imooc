package com.srs.imooc.player;

public class TestDemo {


    public void testSong() {
        Song s001 = new Song("s001", "两只老虎", "小太阳");
        Song s002 = new Song("s002", "小燕子", "风车");
        Song s003 = new Song("s003", "茉莉花", "彩虹");
        Song s004 = new Song("s003", "茉莉花", "彩虹");

        System.out.println(s001);

        System.out.println(s001 == s003);
        System.out.println(s002.equals(s003));
        System.out.println(s003.equals(s004));
        System.out.println(s003 == s004);
    }

    public void testPlayList() {
        Song s001 = new Song("s001", "两只老虎", "小太阳");
        Song s002 = new Song("s002", "小燕子", "风车");
        Song s003 = new Song("s003", "茉莉花", "彩虹");
        Song s004 = new Song("s003", "茉莉花", "彩虹");

        PlayList playList = new PlayList("主播放列表");
        playList.addToPlayList(s001);
        playList.addToPlayList(s002);
        playList.addToPlayList(s003);
        playList.addToPlayList(s004);
        playList.displauAllSong();

        Song s0011 = playList.searchSongById("s001");
        if (s0011 != null) {
            System.out.println("找到歌曲" + s0011);
        } else {
            System.out.println("未找到歌曲");
        }

        Song s0012 = playList.searchSongByName("小燕子");
        if (s0012 != null) {
            System.out.println("找到歌曲" + s0012);
        } else {
            System.out.println("未找到歌曲");
        }
        Song s005 = new Song("s005", "一首简单的歌", "王力宏");
        playList.updateSong("s003", s005);
        playList.displauAllSong();

        playList.deleteSong("s002");
        playList.displauAllSong();


    }

    public void testPlayListCollection() {
        Song s001 = new Song("s001", "两只老虎", "小太阳");
        Song s002 = new Song("s002", "小燕子", "风车");
        Song s003 = new Song("s003", "茉莉花", "彩虹");

        PlayList mainPlayList = new PlayList("主播放列表");
        mainPlayList.addToPlayList(s001);
        mainPlayList.addToPlayList(s002);
        mainPlayList.addToPlayList(s003);

        PlayerListCollection collection = new PlayerListCollection();

        PlayList favouritePlayList = new PlayList("最喜欢的歌曲");
        favouritePlayList.addToPlayList(mainPlayList.getMusicList().get(0));
        favouritePlayList.addToPlayList(mainPlayList.getMusicList().get(1));
        favouritePlayList.displauAllSong();


        //将两个播放列表放入集合中
        collection.addPlayList(mainPlayList);
        collection.addPlayList(favouritePlayList);

        collection.displayListName();

        PlayList playList = collection.searchPlayListByName("最喜欢的歌曲");
        playList.displauAllSong();


        System.out.println("删除前");
        collection.displayListName();
        System.out.println("删除后");
        collection.deletePlayList(favouritePlayList);
        collection.displayListName();


    }

    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
//        demo.testSong();
//        demo.testPlayList();
        demo.testPlayListCollection();
    }

}
