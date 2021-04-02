package sk.stu.fiit.model.organisation.platform;

import javax.swing.Icon;

/**
 *
 * @author Martin Melisek
 */
public class Avatar {

    private Icon image;

    public Avatar(Icon image) {
        this.image = image;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

}