package com.srs.imooc.base.player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerListCollection implements Serializable {


    /**
     * 存放播放列表集合
     */
    private Map<String, PlayList> playListMap;

    public PlayerListCollection() {
        this.playListMap = new HashMap<>();
    }

    public Map<String, PlayList> getPlayListMap() {
        return playListMap;
    }

    public void setPlayListMap(Map<String, PlayList> playListMap) {
        this.playListMap = playListMap;
    }

    /**
     * 向播放列表集合中，添加播放列表
     * @param playList
     */
    public void addPlayList(PlayList playList) {
        this.playListMap.put(playList.getPlayListName(), playList);
    }

    /**
     * 向播放列表集合中，添加播放列表
     * @param playList
     */
    public void deletePlayList(PlayList playList) {
        this.playListMap.remove(playList.getPlayListName());
        System.out.println("删除成功");
    }


    /**
     * 通过播放列表名称查询
     * @param playListName
     * @return
     */
    public PlayList searchPlayListByName(String playListName) {
        Set<String> strings = this.playListMap.keySet();
        if (strings.contains(playListName)) {
            return this.playListMap.get(playListName);
        } else {
            return null;
        }
    }

    /**
     * 查询所有的播放列表
     */
    public void displayListName() {
        Set<String> strings = this.playListMap.keySet();
        System.out.println("播放列表名称为：");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
