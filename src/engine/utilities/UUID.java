package engine.utilities;

import engine.Constants;

public class UUID {

    private String uuid;

    public UUID(){
        this.uuid = java.util.UUID.randomUUID().toString();
        if (!Constants.UUID_LIST.contains(this)) {
            Constants.UUID_LIST.add(this);
        }
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return getUuid();
    }
}
