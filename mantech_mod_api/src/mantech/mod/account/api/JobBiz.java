/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.api;

import java.util.List;
import mantech.mod.account.entity.Job;

/**
 *
 * @author NGUYEN
 */
public interface JobBiz {

    List<Job> findAll();
}
