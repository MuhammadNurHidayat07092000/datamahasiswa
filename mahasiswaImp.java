package datamahasiswa;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class mahasiswaImp implements mahasiswaInterface{
     
    private final String[] header = {"NIM", "NAMA", "JENIS KELAMIN", "JURUSAN"};
    private final List<mahasiswa> listMhs = new ArrayList<>(); 

    @Override
    public void read(JTable jt) {        
        
        // mengatur bagian table
        // addrow = menambah data di table
        // perulangan karna arraylist
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        
        for (int i = 0; i < listMhs.size(); i++) {
            Object[] os = new Object[4]; //4 jumlah kolom
            os[0] = listMhs.get(i).getNim();
            os[1] = listMhs.get(i).getNama();
            os[2] = listMhs.get(i).getJenis_kelamin();
            os[3] = listMhs.get(i).getJurusan();
            dtm.addRow(os);
            

        }
        jt.setModel(dtm);
    }      

    @Override
    public void create(mahasiswa mhs) {
        listMhs.add(mhs);
        JOptionPane.showMessageDialog(null, "Berhasil disimpan");
    }

    @Override
    public void update(mahasiswa mhs) {
        for (int i = 0; i < listMhs.size(); i++) {
          if(mhs.getNim()== listMhs.get(i).getNim()){
              listMhs.set(i, mhs);
          }  
        }
        JOptionPane.showMessageDialog(null, "Berhasil Diubah");
//        listMhs.set(mhs);
    }
}
