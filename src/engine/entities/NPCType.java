package engine.entities;

public enum NPCType {

    CPNC("CPNC"),
    NPC("NPC");

    String tag;

    NPCType(String tag){
        this.tag = tag;
    }

    public boolean isThisTag(String tag){
        return this.tag.equals(tag);
    }

    public static NPCType getType(String tag){
        if (NPC.isThisTag(tag)){
            return NPC;
        }
        return CPNC;
    }


}
