package Faction2;

import Client.Client;
import Faction.FileLoader;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.List;

public class Faction2 extends JFrame implements ActionListener {
    private JButton btSearch = new JButton("查找密度");
    private JComboBox<String> cbName = new JComboBox<String>();
    private JButton btCancel = new JButton("取消");
    public static String name = "温斯顿";
    public static LinkedHashMap<Integer,Integer> lmp = new LinkedHashMap<Integer, Integer>();

    public Faction2() {
        super("密度");
        this.add(btCancel,BorderLayout.EAST);
        this.add(btSearch, BorderLayout.SOUTH);
        this.add(cbName,BorderLayout.CENTER);
        List<String> keyWord = null;
        try {
            keyWord = FileLoader.getTxt("Char.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < keyWord.size(); i++) {
            cbName.addItem(keyWord.get(i));
        }

        this.setSize(380, 160);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        btCancel.addActionListener(this);
        btSearch.addActionListener(this);
        cbName.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btSearch) {
            name = cbName.getSelectedItem().toString();
            lmp = Search.DensitySearch(name);
        } else if (e.getSource() == btCancel) {
            this.dispose();
            new Client();
        }
    }

}
