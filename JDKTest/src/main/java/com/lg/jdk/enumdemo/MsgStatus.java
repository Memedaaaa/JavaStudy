package com.lg.jdk.enumdemo;


public enum MsgStatus {

    DRAFT(0, "草稿状态") {
        @Override
        public MsgStatus getLast() {
            return null;
        }

        @Override
        public MsgStatus getNext() {
            return SENT;
        }
    },
    SENT(1, "已发送状态") {
        @Override
        public MsgStatus getLast() {
            return DRAFT;
        }

        @Override
        public MsgStatus getNext() {
            return RECEIVED;
        }
    },
    RECEIVED(2, "已接收状态") {
        @Override
        public MsgStatus getLast() {
            return SENT;
        }

        @Override
        public MsgStatus getNext() {
            return VIEWED;
        }
    },
    VIEWED(3, "已查看状态") {
        @Override
        public MsgStatus getLast() {
            return RECEIVED;
        }

        @Override
        public MsgStatus getNext() {
            return DELETED;
        }
    },
    DELETED(4, "已删除状态") {
        @Override
        public MsgStatus getLast() {
            return VIEWED;
        }

        @Override
        public MsgStatus getNext() {
            return null;
        }
    };

    int status;
    String description;

    MsgStatus(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public abstract MsgStatus getLast();

    public abstract MsgStatus getNext();


    @Override
    public String toString() {
        return "MsgStatus{" +
                "status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
