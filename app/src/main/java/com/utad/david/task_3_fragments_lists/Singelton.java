package com.utad.david.task_3_fragments_lists;

import com.utad.david.task_3_fragments_lists.Model.User;

public class Singelton {

    private static Singelton instance = new Singelton();

    public User user;

    private Singelton() {
        user = new User();
    }

    public static Singelton getInstance() {
        if (instance == null){
            synchronized (Singelton.class){
                if (instance == null) {
                    instance = new Singelton();
                }
            }
        }
        return instance;
    }
}
