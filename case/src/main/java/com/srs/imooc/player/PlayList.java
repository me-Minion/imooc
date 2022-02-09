package com.srs.imooc.player;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayList implements Serializable {

    /**
     * 播放列表名称
     */
    private String playListName;

    /**
     * 歌曲集合
     */
    private List<Song> musicList;

    public PlayList(String playListName) {
        this.playListName = playListName;
        this.musicList = new ArrayList<>();
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Song> musicList) {
        this.musicList = musicList;
    }

    /**
     * 向播放列表中添加歌曲
     * @param song
     */
    public void addToPlayList(Song song) {
        //歌曲不能重复
        if (CollectionUtils.isEmpty(this.musicList)){
            this.musicList.add(song);
        } else {
            boolean flag = true;
            for (Song temp : this.musicList) {
                if (temp.equals(song)) {
                    System.out.println("该歌曲已经存在于播放列表中，添加失败！");
                    flag = false;
                    continue;
                }
            }
            if (flag) {
                this.musicList.add(song);
            }
        }
    }

    /**
     * 显示播放列表的所有歌曲
     */
    public void displauAllSong() {
        System.out.println("播放列表中的所有歌曲为：");
        for (Song song : this.musicList) {
            System.out.println(song);
        }
    }

    /**
     * 通过歌曲id，在列表中查询
     * @param id
     * @return
     */
    public Song searchSongById(String id) {

        if (CollectionUtils.isEmpty(this.musicList)) {
            return null;
        }
        for (Song song : this.musicList) {
            if (song.getId().equals(id)) {
                return song;
            }
        }
        return null;
    }

    /**
     * 通过歌曲名称，在列表中查询
     * @param name
     * @return
     */
    public Song searchSongByName(String name) {

        if (CollectionUtils.isEmpty(this.musicList)) {
            return null;
        }
        for (Song song : this.musicList) {
            if (song.getName().equals(name)) {
                return song;
            }
        }
        return null;
    }


    /**
     * 修改播放列表中的歌曲信息
     * @param id
     * @param song
     */
    public void updateSong(String id, Song song) {
        Song song1 = this.searchSongById(id);
        if (song1 == null) {
            System.out.println("没有找到id为" + id + "对应的歌曲信息！");
        }
        //先移除，再添加；做的好点的应该是相同位置的替换
        this.musicList.remove(song1);
        this.musicList.add(song);
    }

    /**
     * 删除歌曲信息
     * @param id
     */
    public void deleteSong(String id) {
        Song song = this.searchSongById(id);
        if (song == null) {
            System.out.println("没有找到id为" + id + "对应的歌曲信息！");
            return;
        }
        this.musicList.remove(song);

    }

}
