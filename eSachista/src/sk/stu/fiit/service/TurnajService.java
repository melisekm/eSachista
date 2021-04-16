package sk.stu.fiit.service;

import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajFormat;
import sk.stu.fiit.model.organisation.platform.turnaj.stages.RoundRobinStage;

/**
 *
 * @author Martin Melisek
 */
public class TurnajService extends Service{
    
    private void vygenerujStage(TurnajFormat format){
        switch (format) {
                case ROUND_ROBIN:
                    return new RoundRobinStage();
//                case SINGLE_ELIMINATION: TODO
//                    t.setStage(new RoundRobinStage());
//                    break;
//                case SWISS:
//                    t.setStage(new RoundRobinStage());
//                    break;
                default:
                    throw new AssertionError();
            }
    }

    public void advanceTurnaj(Turnaj t) {
        if(t.getStage() == null){
            
        }
        
    }

    public void vygenerujHarmonogram(Turnaj t) {
        
    }
    
}
