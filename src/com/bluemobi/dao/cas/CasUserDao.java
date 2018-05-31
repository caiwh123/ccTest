package com.bluemobi.dao.cas;

import java.util.List;
import java.util.Map;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.po.cas.CasUser;

/**
 * 【】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2017-10-16 14:54:41
 * 
 */
public interface CasUserDao extends MyBatisBaseDao {

	void updateLocationInfo(CasUser u);
	/**
	 * 保存【会员】
	 * 
	 * @param casUser
	 * @throws Exception
	 */
	void insertCasUser(CasUser casUser) throws Exception;

	/**
	 * 回收或还原【会员】
	 * 
	 * @param paramMap
	 * @throws Exception
	 */
	void updateCasUser4recycle(Map<String, Object> paramMap) throws Exception;

	/**
	 * 批量回收或还原【会员】
	 * 
	 * @param paramMap
	 * @throws Exception
	 */
	void updateBatchCasUser4recycle(Map<String, Object> paramMap) throws Exception;

	/**
	 * 冻结或解冻【会员】
	 * 
	 * @param paramMap
	 * @throws Exception
	 */
	void updateCasUser4IsFreeze(Map<String, Object> paramMap) throws Exception;

	/**
	 * 根据【用户名】查询【前台用户】的数量
	 * 
	 * @param username
	 * @return
	 * @author hapday
	 * @throws Exception
	 *             2016年3月25日 上午11:44:06
	 */
	byte selectCasUserCountByUsername(String username) throws Exception;

	/**
	 * 根据【用户名】查询【前台用户】
	 * 
	 * @param username
	 *            用户名
	 * @return 【前台用户】
	 * @throws Exception
	 * @author hapday 2016年3月25日 下午2:34:46
	 */
	CasUser selectCasUserByUsername(String username) throws Exception;
	
	
	
	CasUser selectCasUserByUsernameForMap(Map<String, Object> requestMap) throws Exception;
	/**
	 * 根据【用户名】更新【前台用户】的【密码】
	 * 
	 * @param requestMap
	 * @throws Exception
	 *             2016年3月29日 下午3:16:23
	 */
	void updateCasUser4passwordByUsername(Map<String, String> requestMap) throws Exception;

	/**
	 * 根据【用户ID】更新【前台用户】的【密码】
	 * 
	 * @param requestMap
	 * @throws Exception
	 *             2016年3月29日 下午3:16:23
	 */
	void updateCasUser4passwordByUserid(Map<String, String> requestMap) throws Exception;

	/**
	 * 根据【ID】查询【前台用户】
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 *             2016年4月1日 下午4:55:19
	 */
	CasUser selectCasUserById(long id) throws Exception;

	/**
	 * 根据【ID】更新【前台用户】
	 * 
	 * @param casUser
	 * @throws Exception
	 *             2016年4月1日 下午4:55:53
	 */
	void updateCasUserById(CasUser casUser) throws Exception;

	/**
	 * 根据【ID】更新【前台用户】 4Account
	 * 
	 * @param requestMap
	 * @throws Exception
	 *             2016年4月1日 下午4:55:53
	 */
	public void updateCasUser4passwordByAccount(Map<String, String> requestMap) throws Exception;

	/**
	 * 根据第三方id和类型查询casUser
	 * 
	 * @param casUser
	 * @return
	 */
	CasUser selectThirdByThirdIdAndThirdLoginType(CasUser casUser);

	/**
	 * 根据【账户】查询【前台用户】的数量
	 * 
	 * @param username
	 * @return
	 * @author hapday
	 * @throws Exception
	 *             2016年6月8日 17:10:16
	 */
	byte selectCasUserCountByAccount(String mobile);

	/**
	 * 根据【account】更新【前台用户】 的【昵称】
	 * 
	 * @param requestMap
	 * @throws Exception
	 *             2016年4月1日 下午4:55:53
	 */
	public void updateCasUserNicknameByAccount(Map<String, String> requestMap) throws Exception;

	/**
	 * 根据【userid】更新【前台用户】 的【昵称】
	 * 
	 * @param requestMap
	 * @throws Exception
	 *             2016年4月1日 下午4:55:53
	 */
	public void updateCasUserNicknameByUserid(Map<String, String> requestMap) throws Exception;

	/**
	 * 根据【account】更新【前台用户】 的【头像地址】
	 * 
	 * @param requestMap
	 * @throws Exception
	 *             2016年4月1日 下午4:55:53
	 */
	public void updateCasUserPicByAccount(Map<String, String> requestMap) throws Exception;

	/**
	 * 根据【userid】更新【前台用户】 的【头像地址】
	 * 
	 * @param requestMap
	 * @throws Exception
	 *             2016年4月1日 下午4:55:53
	 */
	public void updateCasUserPicByUserid(Map<String, String> requestMap) throws Exception;

	void updatePwdByAccount(CasUser casUser);

	byte selectDealerUserCountByAccount(String mobile);

	byte selectRepairUserCountByAccount(String mobile);

	CasUser selectCasUser(Map<String, Object> parameter);


	String selectShowGetFlowers(Map<String, Object> map);

	List<Integer> selectGoodsIds(Map<String, Object> parameter);

	String selectGoodsGetFlowers(Map<String, Object> map);

	void updateStoreStatus(CasUser user);

	CasUser selectUserById(Map<String, Object> userMap);

	void updateNickname(Map<String, String> map);
	int selectLowerLevelNum(String userId);
	CasUser selectUserInfo(Map<String, String> prmMap);
	CasUser selectCasUserByThirdId(Map<String, Object> paraMap);
	List<String> selectUserByFilter(Map<String, Object> map);
	List<String> selectInDistinceList(Map<String, Object> map);
}
