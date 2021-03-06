package com.example.focusapp.A_F;

import java.io.Serializable;

/**
 *  实体类
 */
public class Notes implements Serializable {

    private String NotesContent;

    private String NotesType;//待办时间类型0为目标制定，1为习惯养成
    private String UnitOfTime;//时间单位
    private float HaveFinishMinutes;//已经完成时长,存储时使用分钟做单位
    private float ResMinutes;//剩余时长
    private float TotalTime;//总时长
    private int FinishedTimes;//完成次数
    private String WorkFrequency;
    private int[] FinishDate = new int[]{};//完成日期，年月日
    private int[] CreateDate = new int[]{};//创建日期，年月日

    Notes(){};
    public Notes(String  Content,String type,int totalTime,String unitOfTime,int[] finishDate,int [] createDate){
        NotesContent = Content;
        NotesType = type;
        TotalTime = totalTime;
        UnitOfTime = unitOfTime;
        FinishDate = finishDate.clone();
        CreateDate = createDate.clone();
    };

    public Notes(String  Content,String type,int totalTime,String unitOfTime,int haveFinishMinutes,int[] finishDate){
        NotesContent = Content;
        NotesType = type;
        TotalTime = totalTime;
        UnitOfTime = unitOfTime;
        HaveFinishMinutes = haveFinishMinutes;
        FinishDate = finishDate;
    };
    public Notes(String  Content,String type,int totalTime,String unitOfTime,int haveFinishMinutes,String frequency){
        NotesContent = Content;
        NotesType = type;
        TotalTime = totalTime;
        UnitOfTime = unitOfTime;
        HaveFinishMinutes = haveFinishMinutes;
        WorkFrequency = frequency;
    };
    public Notes (String Content,String type){
        NotesContent = Content;
        NotesType = type;
    };

    public String getUnitOfTime() {
        return UnitOfTime;
    }

    public void setUnitOfTime(String unitOfTime) {
        UnitOfTime = unitOfTime;
    }

    public String getType() {
        return NotesType;
    }

    public void setType(String type) {
        NotesType = type;
    }

    public float getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(float totalTime) {
        TotalTime = totalTime;
    }

    public String getWorkFrequency() {
        return WorkFrequency;
    }

    public void setWorkFrequency(String workFrequency) {
        WorkFrequency = workFrequency;
    }

    public String getNotesContent() {
        return NotesContent;
    }

    public void setNotesContent(String notesContent) {
        NotesContent = notesContent;
    }

    public int[] getFinishDate() {
        return FinishDate;
    }

    public void setFinishDate(int[] finishDate) {
        FinishDate = finishDate;
    }

    public int[] getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(int[] createDate) {
        CreateDate = createDate;
    }

    public String getNotesType() {
        return NotesType;
    }

    public void setNotesType(String notesType) {
        NotesType = notesType;
    }

    public float getHaveFinishMinutes() {
        return HaveFinishMinutes;
    }

    public void setHaveFinishMinutes(int haveFinishMinutes) {
        HaveFinishMinutes = haveFinishMinutes;
    }

    public float getResMinutes() {
        return ResMinutes;
    }

    public void setResMinutes(int resMinutes) {
        ResMinutes = resMinutes;
    }

    public int getFinishedTimes() {
        return FinishedTimes;
    }

    public void setFinishedTimes(int finishedTimes) {
        FinishedTimes = finishedTimes;
    }
}
