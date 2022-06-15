package D2.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class GetItems {
    @JsonProperty("region_id")
    private int regionId;
    private String region_name;
    private List<GetLinks> links;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public List<GetLinks> getLinks() {
        return links;
    }

    public void setLinks(List<GetLinks> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "GetItems{" +
                "region_id=" + regionId +
                ", region_name='" + region_name + '\'' +
                ", links=" + links +
                '}';
    }
}
