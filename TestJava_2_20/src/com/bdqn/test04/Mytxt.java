package com.bdqn.test04;

import java.io.File;
import java.io.IOException;

public class Mytxt {
    public void myCreate() throws IOException {
        File file = new File("D:\\myhello.txt");
        file.createNewFile();
    }

}
