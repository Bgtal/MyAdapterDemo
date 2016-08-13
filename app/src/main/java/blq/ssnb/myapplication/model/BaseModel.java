package blq.ssnb.myapplication.model;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/8/13
 * 描述: 如果要在一个List中显示的数据model 有多种的话
 * 可以先设置一个BaseModel 来规范数据类型
 * ================================================
 */
public class BaseModel {
    public int getType() {
        return type.getType();
    }

    protected void setType(ModelType type) {
        this.type = type;
    }

    public enum ModelType{
        TYPE_ONE(0),
        TYPE_TWO(1),
        TYPE_THREE(2);

        int type ;
        ModelType(int type){
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    private ModelType type;

}
