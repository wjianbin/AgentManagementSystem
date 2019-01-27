package cn.bdqn.sys.service.impl;

import cn.bdqn.sys.entity.AsRolePremission;
import cn.bdqn.sys.entity.AsUser;
import cn.bdqn.sys.mapper.AsRolePremissionMapper;
import cn.bdqn.sys.service.IAsRolePremissionService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhou
 * @since 2018-12-29
 */
@Service
public class AsRolePremissionServiceImpl extends ServiceImpl<AsRolePremissionMapper, AsRolePremission> implements IAsRolePremissionService {

	@Autowired
	private AsRolePremissionMapper asRolePremissionMapper;
	@Override
	public List<AsRolePremission> showRolePremissionById(long roleId) {
		// TODO Auto-generated method stub
		QueryWrapper<AsRolePremission> mapper = new QueryWrapper<>();
		mapper.eq("roleId",roleId);
		List<AsRolePremission> RolePremissionList = asRolePremissionMapper.selectList(mapper);
		return RolePremissionList;
	}

	 @Transactional
	 @Override
		public boolean AddOrDelete(String[] list, long roleId, AsUser user) {
			// TODO Auto-generated method stub
			List<AsRolePremission> oldlist = this.showRolePremissionById(roleId);
			System.out.println("!@@@@@@@@@@@@@@@@!!!!!!!!!!!!");
			try {
				for (AsRolePremission asRolePremission : oldlist) {
					boolean flag = false;
					for (String newlist : list) {
						if (newlist == null || newlist.equals("")) {
							break;
						}
						if (String.valueOf(asRolePremission.getFunctionId()).equals(newlist)) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						asRolePremissionMapper.deleteById(asRolePremission.getId());
					}
				}
				for (String newlist : list) {
					if (newlist == null || newlist.equals("")) {
						break;
					}
					boolean flag = false;
					for (AsRolePremission asRolePremission : oldlist) {
						if (String.valueOf(asRolePremission.getFunctionId()).equals(newlist)) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						AsRolePremission asRolePremission = new AsRolePremission();
						asRolePremission.setIsStart(1);
						asRolePremission.setRoleId((long) roleId);
						asRolePremission.setFunctionId((long) Integer.valueOf(newlist));
						asRolePremission.setCreatedBy(user.getUserName());
						asRolePremission.setCreationTime(LocalDateTime.now());
						asRolePremissionMapper.insert(asRolePremission);
					}
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return false;

			}
			
			return true;
		}


}
