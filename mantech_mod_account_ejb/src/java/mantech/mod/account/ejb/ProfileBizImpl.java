/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantech.mod.account.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import mantech.mod.account.api.ProfileBiz;
import mantech.mod.account.dal.Update;
import mantech.mod.account.entity.Profile;
import mantech.mod.account.jpa.ProfileJpaController;

/**
 *
 * @author NGUYEN
 */
@Stateless(name = "ProfileBiz", mappedName = "ejb/mantech/saigon/ProfileBiz")
@Remote(mantech.mod.account.api.ProfileBiz.class)
public class ProfileBizImpl implements ProfileBiz {

    @Override
    public boolean create(Profile profile) {
        try {
            ProfileJpaController controller = new ProfileJpaController();
            controller.create(profile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean edit(Profile profile) {
        try {
            ProfileJpaController controller = new ProfileJpaController();
            controller.edit(profile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean remove(int id) {
        try {
            ProfileJpaController controller = new ProfileJpaController();
            controller.destroy(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Profile find(int id) {
        try {
            ProfileJpaController controller = new ProfileJpaController();
            return controller.findProfile(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Profile> findAll() {
        try {
            ProfileJpaController controller = new ProfileJpaController();
            return controller.findProfileEntities();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Profile> find(int length, int start) {
        try {
            ProfileJpaController controller = new ProfileJpaController();
            return controller.findProfileEntities(length, start);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Profile> findTechnician() {
        try {
            List<Profile> listAll = this.findAll();
            List<Profile> technicianList = new ArrayList<Profile>();
            for (Profile p : listAll) {
                if (p.getJob().getJob().equalsIgnoreCase("technician")) {
                    technicianList.add(p);
                }
            }
            return technicianList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Profile find(String image) {
        Profile profile = new Profile();
        try {
            List<Profile> all = findAll();
            for (Profile p : all) {
                if (p.getImage().equalsIgnoreCase(image)) {
                    profile = p;
                }
            }
            return profile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean UpdateProfileTechnician(Profile profile) {
            Update account = new  Update();
           return account.UpdateTechnicant(profile);
    }
}
