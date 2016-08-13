package blq.ssnb.myapplication.model;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/8/13
 * 描述:
 * 添加描述
 * ================================================
 */
public class TypeThreeModel extends BaseModel{

    public TypeThreeModel(){
        setType(ModelType.TYPE_THREE);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    private String title;
    private String subTitle;
    private String random;
}
