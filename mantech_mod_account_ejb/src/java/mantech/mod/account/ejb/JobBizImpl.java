/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantech.mod.account.ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import mantech.mod.account.api.JobBiz;
import mantech.mod.account.entity.Job;
import mantech.mod.account.jpa.JobJpaController;

/**
 *
 * @author NGUYEN
 */
@Stateless(name = "JobBiz", mappedName = "ejb/mantech/saigon/JobBiz")
@Remote(mantech.mod.account.api.JobBiz.class)
public class JobBizImpl implements JobBiz {

    @Override
    public List<Job> findAll() {
        try {
            JobJpaController controller = new JobJpaController();
            return controller.findJobEntities();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
