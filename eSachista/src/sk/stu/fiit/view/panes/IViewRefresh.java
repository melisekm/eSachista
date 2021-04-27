package sk.stu.fiit.view.panes;

/**
 * Funkcionalny interace pre vsetky panely, ktore dynamicky obnovuju svoj obsah
 * pri zmene tabu
 *
 * @author Martin Melisek
 */
@FunctionalInterface
public interface IViewRefresh {

    void refresh();
}
