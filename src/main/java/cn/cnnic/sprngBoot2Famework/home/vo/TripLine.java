package cn.cnnic.sprngBoot2Famework.home.vo;

public class TripLine {
    private Integer lineId;

    private String lineName;

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }
}