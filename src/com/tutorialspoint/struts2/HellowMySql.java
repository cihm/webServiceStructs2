package com.tutorialspoint.struts2;

import java.util.ArrayList;
import java.util.List;

import com.tutorial.impdao.PeopleDao;
import com.tutorial.vo.PeopleVo;

public class HellowMySql {
	public int id;
	public String name;
	public String school;
	public int age;
	public ArrayList<PeopleVo> daoL = new ArrayList<PeopleVo>();
	
	public String insert() throws Exception {
		PeopleDao dao = PeopleDao.getInstance();
		PeopleVo vo = new PeopleVo();
		//vo.setId(id);
		vo.setName(name);
		vo.setSchool(school);
		vo.setAge(age);
		System.out.println("insert to db: "+id+":"+name+":"+school+":"+age);
		dao.insert(vo);
		
		List<PeopleVo> daoDB = dao.selectALL(vo);
	    for(int i = 0 ; i < daoDB.size() ; i++)
	    {
	    	PeopleVo vod = new PeopleVo();
	    	vod.setId(daoDB.get(i).getId());  
	    	vod.setName(daoDB.get(i).getName()); 
	    	vod.setSchool(daoDB.get(i).getSchool()); 
	    	vod.setAge(daoDB.get(i).getAge()); 
	    	
	    	daoL.add(vod); 
	    	System.out.println("query from db:"+vod.getName());
	    }
		return "success";
	}
	
	public String QueryByName() throws Exception {
		PeopleDao dao = PeopleDao.getInstance();
		PeopleVo vo = new PeopleVo();
		vo.setName(name);
		System.out.println("QueryByName :"+name);
		
		List<PeopleVo> daoDB = dao.selectByName(vo);
	    for(int i = 0 ; i < daoDB.size() ; i++)
	    {
	    	PeopleVo vod = new PeopleVo();
	    	vod.setId(daoDB.get(i).getId());  
	    	vod.setName(daoDB.get(i).getName()); 
	    	vod.setSchool(daoDB.get(i).getSchool()); 
	    	vod.setAge(daoDB.get(i).getAge()); 
	    	
	    	daoL.add(vod); 
	    	System.out.println("query from db:"+vod.getName());
	    }
		return "success";
	}
	
	
	public String QueryBySchool() throws Exception {
		PeopleDao dao = PeopleDao.getInstance();
		PeopleVo vo = new PeopleVo();
		vo.setSchool(school);
		System.out.println("QueryBySchool: "+school);
		
		List<PeopleVo> daoDB = dao.selectBySchool(vo);
	    for(int i = 0 ; i < daoDB.size() ; i++)
	    {
	    	PeopleVo vod = new PeopleVo();
	    	vod.setId(daoDB.get(i).getId());  
	    	vod.setName(daoDB.get(i).getName()); 
	    	vod.setSchool(daoDB.get(i).getSchool()); 
	    	vod.setAge(daoDB.get(i).getAge()); 
	    	
	    	daoL.add(vod); 
	    	System.out.println("query from db:"+vod.getName());
	    }
		return "success";
	}
	
	public String UpdateByName() throws Exception {
		PeopleDao dao = PeopleDao.getInstance();
		PeopleVo vo = new PeopleVo();
		vo.setName(name);
		vo.setSchool(school);
		vo.setAge(age);
		System.out.println("UpdateByName: "+name);
		
		System.out.println("before UpdateByName: "+name);
		
		List<PeopleVo> daoDB = dao.selectByName(vo);
	    for(int i = 0 ; i < daoDB.size() ; i++)
	    {
	    	PeopleVo vod = new PeopleVo();
	    	vod.setId(daoDB.get(i).getId());  
	    	vod.setName(daoDB.get(i).getName()); 
	    	vod.setSchool(daoDB.get(i).getSchool()); 
	    	vod.setAge(daoDB.get(i).getAge()); 
	    	
	    	daoL.add(vod); 
	    }
		
		dao.update(vo);
		
		List<PeopleVo> daoDBa = dao.selectByName(vo);
	    for(int i = 0 ; i < daoDB.size() ; i++)
	    {
	    	PeopleVo vod = new PeopleVo();
	    	vod.setId(daoDBa.get(i).getId());  
	    	vod.setName(daoDBa.get(i).getName()); 
	    	vod.setSchool(daoDBa.get(i).getSchool()); 
	    	vod.setAge(daoDBa.get(i).getAge()); 
	    	
	    	daoL.add(vod); 
	    }
		return "success";
	}
	
	public String DeleteAll() throws Exception {
		PeopleDao dao = PeopleDao.getInstance();
		PeopleVo vo = new PeopleVo();
		System.out.println("DeleteAll");
		
		dao.delete(vo);
		
		List<PeopleVo> daoDB = dao.selectALL(vo);
	    for(int i = 0 ; i < daoDB.size() ; i++)
	    {
	    	PeopleVo vod = new PeopleVo();
	    	vod.setId(daoDB.get(i).getId());  
	    	vod.setName(daoDB.get(i).getName()); 
	    	vod.setSchool(daoDB.get(i).getSchool()); 
	    	vod.setAge(daoDB.get(i).getAge()); 
	    	
	    	daoL.add(vod); 
	    	System.out.println("query from db:"+vod.getName());
	    }
		return "success";
	}
	
	public String DeleteBySchool() throws Exception {
		PeopleDao dao = PeopleDao.getInstance();
		PeopleVo vo = new PeopleVo();
		System.out.println("DeleteBySchool :"+ school);
		vo.setSchool(school);
		dao.deleteBySchool(vo);
		
		List<PeopleVo> daoDB = dao.selectALL(vo);
	    for(int i = 0 ; i < daoDB.size() ; i++)
	    {
	    	PeopleVo vod = new PeopleVo();
	    	vod.setId(daoDB.get(i).getId());  
	    	vod.setName(daoDB.get(i).getName()); 
	    	vod.setSchool(daoDB.get(i).getSchool()); 
	    	vod.setAge(daoDB.get(i).getAge()); 
	    	
	    	daoL.add(vod); 
	    	System.out.println("query from db:"+vod.getName());
	    }
		return "success";
	}
	
	
	public ArrayList<PeopleVo> getDaoList() {  
	    return daoL;  
	}  
	public void setDaoList(ArrayList<PeopleVo> daoL) {  
	    this.daoL = daoL;  
	} 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		System.out.println("call getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("call setName");
		this.name = name;
	}
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}