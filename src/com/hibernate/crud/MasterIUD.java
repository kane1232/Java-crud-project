package com.hibernate.crud;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.hibernate.entities.Member;
import com.hibernate.entities.PostDetail;
import com.hibernate.entities.PostMaster;
import com.hibernate.filter.FilterPostdetail;
import com.hibernate.filter.FilterPostmaster;
import com.hibernate.filter.Filtermember;
import com.hibernate.report.ReportMember;
import com.hibernate.report.ReportPostdetail;
import com.hibernate.report.ReportPostmaster;
import com.hibernate.util.HibernateUtil;

public class MasterIUD {

	public String InsertMaster(FilterPostmaster mt,FilterPostdetail dt)throws Exception {
		String info = null;
		PostMaster pm = new PostMaster();
		PostDetail pd = new PostDetail();
		
		try{
			HibernateUtil.beginTransaction(); 
			Session s = HibernateUtil.getSession();
			
			if(mt != null && dt != null){
				pm.setComcode(mt.getComcode());
				pm.setTopic(mt.getTopic());
				pm.setContent(mt.getContent());
				pd.setScreen(dt.getScreen());
				pd.setContact(dt.getContact());
				pd.setTelNum(dt.getTelNum());
				pd.setUserDate(dt.getUserDate());
				pd.setDocno(dt.getDocno());
				
				s.save(pm);
				s.save(pd);
				
				info = "Insert complete";
				HibernateUtil.commitTransaction();
				
			}
			
		}catch(Exception e){
			HibernateUtil.rollBackTransaction();
			info = e.toString();
		}finally{
			HibernateUtil.closeSession();
		}
		return info;		
	}
	
	
	@SuppressWarnings("deprecation")
	public  String InsertOrUpdateMember(Filtermember mb ) throws Exception{
		String info = null;
		try{
			HibernateUtil.beginTransaction(); 
			Session s = HibernateUtil.getSession();

			if(mb != null){
			Criteria criteria = s.createCriteria(Member.class)
					.add(Restrictions.like("comcode",mb.getComcode()))
					.add(Restrictions.like("level",mb.getLevel()))
					.add(Restrictions.like("status",mb.getStatus()))
					.add(Restrictions.like("memDate",mb.getMemDate()))
					.add(Restrictions.like("memberId",mb.getMemberId()));
			if(criteria.list().size() == 1){
				Member mem = (Member) criteria.list().get(0);
				mem.setLevel(mb.getLevel());
				mem.setMemberName(mb.getMemberName());
				mem.setStatus(mb.getStatus());
				mem.setMemDate(mb.getMemDate());
				mem.setComcode(mb.getComcode());
				
				s.update(mem);
				s.save(mem);
				
				info = "Update complete";
				HibernateUtil.commitTransaction();
				
			}
			else{
				Member mem = new Member();
				mem.setLevel(mb.getLevel());
				mem.setMemberName(mb.getMemberName());
				mem.setStatus(mb.getStatus());
				mem.setMemDate(mb.getMemDate());
				mem.setComcode(mb.getComcode());
				
				s.save(mem);
				info = "Insert complete";
				HibernateUtil.commitTransaction();
				
			}
			}
		}catch(Exception e){
			HibernateUtil.rollBackTransaction();
			info = e.toString();
		}
		finally{
			HibernateUtil.closeSession();
		}
		
		return info;
	}
	
	@SuppressWarnings("deprecation")
	public String DeleteMaster(String Docno,String comcode ) throws Exception{
		
		String info =null;
		try{
			HibernateUtil.beginTransaction(); 
			Session s = HibernateUtil.getSession();
			
			/*Member mem = (Member) s.createCriteria(Member.class)
			.add(Restrictions.eq("memberId", memberId)).uniqueResult();*/
			/*Criteria master = s.createCriteria(PostMaster.class)
					.add(Restrictions.eq("comcode",comcode));*/
			Criteria detail = s.createCriteria(PostDetail.class)
					.add(Restrictions.eq("Docno",Docno));
			Criteria member = s.createCriteria(Member.class)
					//.add(Restrictions.eq("memberId", memberId))
					.add(Restrictions.eq("comcode", comcode));
			
			//s.delete(master);
			s.delete(detail);
			s.delete(member);
			
			info = "Delete complete";
			HibernateUtil.commitTransaction();
		}catch(Exception e){
			HibernateUtil.rollBackTransaction();
			info = e.toString();
		}
		finally
		{
			HibernateUtil.closeSession();
		}
		
		return info;
	}
	@SuppressWarnings("deprecation")
	public ReportPostmaster[] FindAll(String comcode,int page,int pagesize) throws Exception{
		ReportPostmaster[] master =null;
		try{
			//HibernateUtil.beginTransaction();
			Session s = HibernateUtil.getSession();
			Criteria criteria = s.createCriteria(PostMaster.class);
			criteria.add(Restrictions.like("comcode",comcode));
			
			int totalrow = criteria.list().size();
			int firstrow = (page-1)*pagesize;
			criteria.setFirstResult(firstrow);
			criteria.setMaxResults(pagesize);
			
			List empList = criteria.list();
			master = new ReportPostmaster[empList.size()];
			
			for(int i =0; i < master.length; i++ ){
				master[i] = new ReportPostmaster((PostMaster)empList.get(1),new Integer(totalrow)); 
			}
			
		}catch(Exception e){
			throw new Exception (e.toString());
		}			
		return master;
		
	}
	
	public ReportPostdetail[] FindByDocno(String Docno,int page,int pagesize) throws Exception{
		
		ReportPostdetail[] detail =null;
		try{
			HibernateUtil.beginTransaction();
			Session s = HibernateUtil.getSession();
			Criteria criteria = s.createCriteria(PostDetail.class);
			criteria.add(Restrictions.like("Docno",Docno));
			
			int totalrow = criteria.list().size();
			int firstrow = (page-1)*pagesize;
			criteria.setFirstResult(firstrow);
			criteria.setMaxResults(pagesize);
			
			List empList = criteria.list();
			detail = new ReportPostdetail[empList.size()];
			
			for(int i =0; i < detail.length; i++ ){
				detail[i] = new ReportPostdetail((PostDetail)empList.get(1),new Integer(totalrow)); 
			}
			
		}catch(Exception e){
			throw new Exception (e.toString());
		}	
		
		return detail;
		
	}
	
	@SuppressWarnings("deprecation")
	public ReportPostdetail[] FindByUser(String user,int page,int pagesize)  throws Exception{

		ReportPostdetail[] detail =null;
		try{
			HibernateUtil.beginTransaction();
			Session s = HibernateUtil.getSession();
			Criteria criteria = s.createCriteria(PostDetail.class);
			criteria.add(Restrictions.like("user",user));
			
			int totalrow = criteria.list().size();
			int firstrow = (page-1)*pagesize;
			criteria.setFirstResult(firstrow);
			criteria.setMaxResults(pagesize);
			
			List empList = criteria.list();
			detail = new ReportPostdetail[empList.size()];
			
			for(int i =0; i < detail.length; i++ ){
				detail[i] = new ReportPostdetail((PostDetail)empList.get(1),new Integer(totalrow)); 
			}
			
		}catch(Exception e){
			throw new Exception (e.toString());
		}	
		
		return detail;	
	}
	
	@SuppressWarnings("deprecation")
	public ReportMember[] FindByStatus (String status,int page,int pagesize)throws Exception {
		

		ReportMember[] detail =null;
		try{
			HibernateUtil.beginTransaction();
			Session s = HibernateUtil.getSession();
			Criteria criteria = s.createCriteria(Member.class);
			criteria.add(Restrictions.like("status",status));
			
			int totalrow = criteria.list().size();
			int firstrow = (page-1)*pagesize;
			criteria.setFirstResult(firstrow);
			criteria.setMaxResults(pagesize);
			
			List empList = criteria.list();
			detail = new ReportMember[empList.size()];
			
			for(int i =0; i < detail.length; i++ ){
				detail[i] = new ReportMember((Member)empList.get(1),new Integer(totalrow)); 
			}
			
		}catch(Exception e){
			throw new Exception (e.toString());
		}	
		
		return detail;	
		
	}
	
	public ReportPostmaster[] FindByTopic(String topic,int page,int pagesize) throws Exception{
		ReportPostmaster[] master =null;
		try{
			HibernateUtil.beginTransaction();
			Session s = HibernateUtil.getSession();
			Criteria criteria = s.createCriteria(PostMaster.class);
			criteria.add(Restrictions.like("topic","%" + topic + "%"));
			
			int totalrow = criteria.list().size();
			int firstrow = (page-1)*pagesize;
			criteria.setFirstResult(firstrow);
			criteria.setMaxResults(pagesize);
			
			List empList = criteria.list();
			master = new ReportPostmaster[empList.size()];
			
			for(int i =0; i < master.length; i++ ){
				master[i] = new ReportPostmaster((PostMaster)empList.get(1),new Integer(totalrow)); 
			}
			
		}catch(Exception e){
			throw new Exception (e.toString());
		}			
		return master;	
		
	}
	public ReportMember[] FindBymemName(String memberName,int page,int pagesize) throws Exception{
		
		ReportMember[] detail =null;
		try{
			HibernateUtil.beginTransaction();
			Session s = HibernateUtil.getSession();
			@SuppressWarnings("deprecation")
			Criteria criteria = s.createCriteria(Member.class);
			criteria.add(Restrictions.like("memberName",memberName));
			
			int totalrow = criteria.list().size();
			int firstrow = (page-1)*pagesize;
			criteria.setFirstResult(firstrow);
			criteria.setMaxResults(pagesize);
			
			List empList = criteria.list();
			detail = new ReportMember[empList.size()];
			
			for(int i =0; i < detail.length; i++ ){
				detail[i] = new ReportMember((Member)empList.get(1),new Integer(totalrow)); 
			}
			
		}catch(Exception e){
			throw new Exception (e.toString());
		}	
		
		return detail;	
		
	}
	
	public ReportPostdetail[] FindByuserDate(String Date,int page,int pagesize) throws Exception{
		ReportPostdetail[] detail =null;
		try{
			HibernateUtil.beginTransaction();
			Session s = HibernateUtil.getSession();
			@SuppressWarnings("deprecation")
			Criteria criteria = s.createCriteria(PostDetail.class);
			criteria.add(Restrictions.like("userDate",Date));
			
			int totalrow = criteria.list().size();
			int firstrow = (page-1)*pagesize;
			criteria.setFirstResult(firstrow);
			criteria.setMaxResults(pagesize);
			
			List empList = criteria.list();
			detail = new ReportPostdetail[empList.size()];
			
			for(int i =0; i < detail.length; i++ ){
				detail[i] = new ReportPostdetail((PostDetail)empList.get(1),new Integer(totalrow)); 
			}
			
		}catch(Exception e){
			throw new Exception (e.toString());
		}		
		return detail;	
		
	}
	
	public ReportMember[] FindBymemDate(String date,int page,int pagesize) throws Exception{
		ReportMember[] detail =null;
		try{
			HibernateUtil.beginTransaction();
			Session s = HibernateUtil.getSession();
			@SuppressWarnings("deprecation")
			Criteria criteria = s.createCriteria(Member.class);
			criteria.add(Restrictions.like("memDate",date));
			
			int totalrow = criteria.list().size();
			int firstrow = (page-1)*pagesize;
			criteria.setFirstResult(firstrow);
			criteria.setMaxResults(pagesize);
			
			List empList = criteria.list();
			detail = new ReportMember[empList.size()];
			
			for(int i =0; i < detail.length; i++ ){
				detail[i] = new ReportMember((Member)empList.get(1),new Integer(totalrow)); 
			}
			
		}catch(Exception e){
			throw new Exception (e.toString());
		}	
		
		return detail;
		
	}
}
