package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg1 = new Zerg ();
        Zerg zerg2 = new Zerg ();
        Zerg zerg3 = new Zerg ();
        Zerg zerg4 = new Zerg ();
        Zerg zerg5 = new Zerg ();
        Zerg zerg6 = new Zerg ();
        Zerg zerg7 = new Zerg ();
        Zerg zerg8 = new Zerg ();
        Zerg zerg9 = new Zerg ();
        Zerg zerg10 = new Zerg ();

        zerg1.name = "za";
        zerg2.name = "zb";
        zerg3.name = "zc";
        zerg4.name = "zd";
        zerg5.name = "ze";
        zerg6.name = "zi";
        zerg7.name = "zj";
        zerg8.name = "zk";
        zerg9.name = "zl";
        zerg10.name = "zp";

        Protos protos1 = new Protos();
        Protos protos2 = new Protos();
        Protos protos3 = new Protos();
        Protos protos4 = new Protos();
        Protos protos5 = new Protos();

        protos1.name = "pa";
        protos2.name = "pb";
        protos3.name = "pc";
        protos4.name = "pd";
        protos5.name = "pe";

        Terran terran1 = new Terran();
        Terran terran2 = new Terran();
        Terran terran3 = new Terran();
        Terran terran4 = new Terran();
        Terran terran5 = new Terran();
        Terran terran6 = new Terran();
        Terran terran7 = new Terran();
        Terran terran8 = new Terran();
        Terran terran9 = new Terran();
        Terran terran10 = new Terran();
        Terran terran11 = new Terran();
        Terran terran12 = new Terran();

        terran1.name = "ta";
        terran2.name = "tb";
        terran3.name = "tc";
        terran4.name = "td";
        terran5.name = "te";
        terran6.name = "tr";
        terran7.name = "tt";
        terran8.name = "ty";
        terran9.name = "tu";
        terran10.name = "ti";
        terran11.name = "tao";
        terran12.name = "tp";

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}