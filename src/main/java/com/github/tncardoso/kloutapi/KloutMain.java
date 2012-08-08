package com.github.tncardoso.kloutapi;

import java.util.List;
import java.util.Vector;

public class KloutMain
{
    public static void main(String[] args) throws Exception
    {
        Klout k = new Klout("78tjssy7b7yhegv8berych62");

        List<String> users = new Vector<String>();
        users.add("lfmendes");
        users.add("charliesheen");
        users.add("tncardoso");

        List<KloutUser> ret = k.show(users);
        for (KloutUser u : ret)
        {
            System.out.println(u.getTwitterScreenName());
            System.out.println(u.getDescription());
            System.out.println(u.getKclassDescription());
            System.out.println(u.getKscoreDescription());
        }
    }
}
