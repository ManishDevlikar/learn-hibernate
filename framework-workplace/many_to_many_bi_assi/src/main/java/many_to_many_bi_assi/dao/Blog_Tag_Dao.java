package many_to_many_bi_assi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_many_bi_assi.dto.Blog;
import many_to_many_bi_assi.dto.Tag;

public class Blog_Tag_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	---------------------------------------create----------------------------------------------------------------------

	public void saveBlog(Blog blog) {
		transaction.begin();
		manager.persist(blog);
		transaction.commit();
	}

	public void saveTag(Tag tag) {
		transaction.begin();
		manager.persist(tag);
		transaction.commit();
	}

	public void saveBlogs(List<Blog> blogs) {
		for (Blog blog : blogs) {
			if (blog.getTags() != null) {

				List<Tag> tags = blog.getTags();
				for (Tag tag : tags) {
					tag.setBlogs(blogs);
				}
				transaction.begin();
				manager.persist(blog);
				transaction.commit();
			} else {
				transaction.begin();
				manager.persist(blog);
				transaction.commit();
			}
		}
	}

//	-------------------------------------------------find--------------------------------------------------------------------

	public void findBlog(int id) {
		Blog blog = manager.find(Blog.class, id);
		if (blog != null) {
			System.out.println(blog);
		}
	}

	public void findTag(int id) {
		Tag tag = manager.find(Tag.class, id);
		if (tag != null) {
			System.out.println(tag);
		}
	}

	public void findAllRecords() {
		Query query = manager.createQuery("select DISTINCT record from Blog record INNER JOIN FETCH record.tags");

		List<Blog> blogList = query.getResultList();
		for (Blog blog : blogList) {
			if (blog != null) {
				List<Tag> tagList = blog.getTags();
				System.out.println(blog);
				for (Tag tag : tagList) {
					if (tag != null) {
						System.out.println(tag);
					}
				}
				System.out.println();
			}
		}
	}

//	--------------------------------------------------update--------------------------------------------------------------------

	public void addNewTagToBlog(int blogId, List<Tag> tagList) {
		Blog blog = manager.find(Blog.class, blogId);

		List<Blog> blogList = new ArrayList<Blog>();
		if (blog != null) {
			blog.getTags().addAll(tagList);
			for (Tag tag : tagList) {
				tag.setBlogs(blogList);
			}
			transaction.begin();
			manager.merge(blog);
			transaction.commit();
		} else {
			System.out.println("Please Enter valid Blog Id");
		}
	}

	public void addExistingTagToBlog(int blogId, int tagId) {
		Blog blog = manager.find(Blog.class, blogId);
		Tag tag = manager.find(Tag.class, tagId);

		if (blog != null && tag != null) {
			List<Blog> blogList = tag.getBlogs();
			List<Tag> tagList = blog.getTags();
			if (!blogList.contains(blog) && !tagList.contains(tag)) {
				blogList.add(blog);
				tagList.add(tag);
				blog.setTags(tagList);
				tag.setBlogs(blogList);
				transaction.begin();
				manager.merge(blog);
				transaction.commit();
			} else {
				System.out.println("same tage already applied");
			}
		} else {
			System.out.println("Check Blog Id and Tag Id");
		}
	}

	public void updateBlogTitle(int blogId, String title) {
		Blog blog = manager.find(Blog.class, blogId);
		if (blog != null) {
			blog.setTitle(title);
			transaction.begin();
			manager.merge(blog);
			transaction.commit();
		}
	}

	public void updateBlogContent(int blogId, String content) {
		Blog blog = manager.find(Blog.class, blogId);
		if (blog != null) {
			blog.setContent(content);
			transaction.begin();
			manager.merge(blog);
			transaction.commit();
		}
	}

//	-------------------------------------------delete-----------------------------------------------------------
	public void deleteTag(int tagId) {
		Tag tag = manager.find(Tag.class, tagId);
		if (tag != null) {
			if (!tag.getBlogs().isEmpty()) {
				List<Blog> blogList = tag.getBlogs();
				for (Blog blog : blogList) {
					blog.getTags().remove(tag);
				}
				tag.setBlogs(null);
				transaction.begin();
				manager.remove(tag);
				transaction.commit();
				System.out.println("tag removed");
			} else {
				transaction.begin();
				manager.remove(tag);
				transaction.commit();
				System.out.println("tag removed");
			}
		} else {
			System.out.println("Check tag Id");
		}
	}

	public void deleteBlog(int blogId) {
		Blog blog = manager.find(Blog.class, blogId);

		if (blog != null) {
			if (!blog.getTags().isEmpty()) {
				List<Tag> tagList = blog.getTags();
				for (Tag tag : tagList) {
					tag.getBlogs().remove(blog);
				}
				blog.setTags(null);
				transaction.begin();
				manager.remove(blog);
				transaction.commit();
				System.out.println("blog removed");
			} else {
				transaction.begin();
				manager.remove(blog);
				transaction.commit();
				System.out.println("blog removed");
			}
		} else {
			System.out.println("check blog Id");
		}
	}

//	public void removeTag(int tagId) {
//		Tag tag = manager.find(Tag.class, tagId);
//
//		if (tag != null) {
//			if (!tag.getBlogs().isEmpty()) {
//				List<Blog> blogList = tag.getBlogs();
//				for (Blog blog : blogList) {
//					blog.getTags().remove(tag);
//				}
//			}
//			tag.setBlogs(null);
//			transaction.begin();
//			manager.merge(tag);
//			transaction.commit();
//
//		}
//	}

	public void removeTagFromBlog(int blogId, int tagId) {
		Blog blog = manager.find(Blog.class, blogId);
		Tag tag = manager.find(Tag.class, tagId);

		if (blog != null && tag != null) {
			if (!blog.getTags().isEmpty() && !tag.getBlogs().isEmpty()) {
				if (blog.getTags().contains(tag) && tag.getBlogs().contains(blog)) {
					blog.getTags().remove(tag);
					tag.getBlogs().remove(blog);
					transaction.begin();
					manager.merge(blog);
					transaction.commit();
				} else {
					System.out.println("blog does not contain such a tag check tag id");
				}
			} else {
				System.out.println("your blog does not contain any tag or tag does not contain any blog");
			}
		} else {
			System.out.println("check blog and and tag id");
		}
	}
}
