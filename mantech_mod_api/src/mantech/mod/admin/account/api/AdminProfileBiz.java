/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.admin.account.api;

import java.util.List;
import mantech.mod.account.entity.Profile;

/**
 *
 * @author NDC
 */
public interface AdminProfileBiz {

    void create(Profile profile);

    void edit(Profile profile);

    void remove(Profile profile);

    Profile find(Object id);

    List<Profile> findAll();

    Profile searchDeparment(String deparmentId);
}
