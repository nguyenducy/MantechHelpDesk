/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.api;

import java.util.List;
import mantech.mod.account.entity.Profile;

/**
 *
 * @author NDC
 */
public interface ProfileBiz {

    boolean create(Profile profile);

    boolean edit(Profile profile);

    boolean remove(int id);

    Profile find(int id);
    
    Profile find(String image);

    List<Profile> findAll();

    List<Profile> find(int length, int start);

    List<Profile> findTechnician();

    boolean UpdateProfileTechnician(Profile profile);
}
