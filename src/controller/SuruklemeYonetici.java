package controller;

import java.awt.Graphics2D;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Sekil;

public class SuruklemeYonetici implements DragSourceListener, DragGestureListener, DropTargetListener {

    private JTextField kaynakBilesen;
    private JLabel hedefBilesen;
    private DragSource suruklenen = DragSource.getDefaultDragSource();
    private SekilUretici su = new SekilUretici();
    private Sekil sekil;

    public SuruklemeYonetici(JTextField kaynakBilesen, JLabel hedefBilesen) {
        this.kaynakBilesen = kaynakBilesen;
        this.hedefBilesen = hedefBilesen;
        kaynakBilesen.setDragEnabled(true);
        int action = DnDConstants.ACTION_COPY;
        suruklenen.createDefaultDragGestureRecognizer(hedefBilesen, action, this);
        new DropTarget(hedefBilesen, action, this);
    }

    @Override
    public void dragEnter(DragSourceDragEvent dsde) {
    }

    @Override
    public void dragOver(DragSourceDragEvent dsde) {
    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dsde) {
    }

    @Override
    public void dragExit(DragSourceEvent dse) {
    }

    @Override
    public void dragDropEnd(DragSourceDropEvent dsde) {
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        Transferable t = new StringSelection(kaynakBilesen.getText());
        dge.startDrag(DragSource.DefaultCopyDrop, t);
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        Transferable t = dtde.getTransferable();
        if (dtde.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                dtde.acceptDrop(dtde.getDropAction());
                String suruklenenMetin = (String) t.getTransferData(DataFlavor.stringFlavor);
                sekil = su.sekilUret(suruklenenMetin);
                Graphics2D g = (Graphics2D) hedefBilesen.getGraphics();
                hedefBilesen.paintAll(g);
                sekil.setX(dtde.getLocation().getX());
                sekil.setY(dtde.getLocation().getY());
                sekil.setEn(50);
                sekil.setBoy(50);
                sekil.Ciz(g);
                hedefBilesen.paintComponents(g);
                dtde.dropComplete(true);
                kaynakBilesen.setText(suruklenenMetin);
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(SuruklemeYonetici.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SuruklemeYonetici.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
