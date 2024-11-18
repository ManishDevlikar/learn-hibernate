package many_to_many_bi_assi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import many_to_many_bi_assi.dao.Blog_Tag_Dao;
import many_to_many_bi_assi.dto.Blog;
import many_to_many_bi_assi.dto.Tag;

public class Blog_Tag_Controller {
	static Blog_Tag_Dao dao = new Blog_Tag_Dao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		runApplication();
	}

	static public void runApplication() {
		System.out.println("Enter your Choice : " + "\n1: To Add New Blogs " + "\n2: Add new Tag To Blog"
				+ "\n3: update Tags of Blog " + "\n4: Delete Tag \n5: Delete Blog " + "\n6: Remove Tag Form Blog "
				+ "\n7: Find Tag By Id " + "\n8: Find Blog By Id \n9: find All Records \n10: Exit");

		System.out.println("enter your choice");
		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.println("do you want to add new Blog (yes/no)");
			String toAddNewBlog = sc.next();
			if (toAddNewBlog.equalsIgnoreCase("yes")) {
				System.out.println("how many Blogs you want to add");
				int totalBlogs = sc.nextInt();
				List<Blog> blogList = new ArrayList<Blog>();
				for (int i = 0; i < totalBlogs; i++) {
					Blog blog = new Blog();
					System.out.println("Enter Blog ID");
					int bId = sc.nextInt();
					blog.setId(bId);
					sc.nextLine();
					System.out.println("Enter Blog Tital");
					String bTital = sc.nextLine();
					System.out.println("Enter Blog Content");
					String bContent = sc.nextLine();
					System.out.println("Enter Blog Author");
					String bAuthor = sc.nextLine();
					blog.setContent(bContent);
					blog.setTitle(bTital);
					blog.setAuthor(bAuthor);
					blogList.add(blog);
					System.out.println(i + 1 + " blog added");
				}
				System.out.println("Do you want to set Tags for Blog (yes/no)");
				String toSetTags = sc.next();
				if (toSetTags.equalsIgnoreCase("yes")) {
					System.out.println("how many Tags you want to set");
					int totalTags = sc.nextInt();
					List<Tag> tagList = new ArrayList<Tag>();
					for (int i = 0; i < totalTags; i++) {
						Tag tag = new Tag();
						System.out.println("Enter Tag ID");
						int tId = sc.nextInt();
						tag.setId(tId);
						System.out.println("Enter Tag name");
						String tName = sc.next();
						tag.setName(tName);
						tagList.add(tag);
						System.out.println(i + 1 + " tag added");
					}

					for (Blog blog : blogList) {
						blog.setTags(tagList);
					}
					dao.saveBlogs(blogList);
					runApplication();
					break;

				} else {
					dao.saveBlogs(blogList);
					runApplication();
					break;
				}

			} else {
				runApplication();
				break;
			}
		case 2:
			System.out.println("Do you want to add new tag to blog(yes/no)");
			String toAddNewTag = sc.next();
			if (toAddNewTag.equalsIgnoreCase("yes")) {
				System.out.println("Enter Blog Id In which You want to add Tag");
				int bId = sc.nextInt();
				System.out.println("how many tags you want to add");
				int totalTags = sc.nextInt();
				List<Tag> tagList = new ArrayList<Tag>();
				for (int i = 0; i < totalTags; i++) {
					Tag tag = new Tag();
					System.out.println("Enter Tag ID");
					int tId = sc.nextInt();
					tag.setId(tId);
					sc.nextLine();
					System.out.println("Enter Tag name");
					String tName = sc.nextLine();
					tag.setName(tName);
					tagList.add(tag);
					System.out.println(i + 1 + " tag added");
				}
				dao.addNewTagToBlog(bId, tagList);
				runApplication();
				break;

			} else {
				runApplication();
				break;
			}
		case 3:
			System.out.println("Do you want to set Existing tag to blog(yes/no)");
			String toSetNewTag = sc.next();
			if (toSetNewTag.equalsIgnoreCase("yes")) {
				System.out.println("Enter Blog Id");
				int bId = sc.nextInt();
				System.out.println("Enetr Tag Id");
				int tId = sc.nextInt();
				dao.addExistingTagToBlog(bId, tId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 4:
			System.out.println("Do you want to Delete tag From database(yes/no)");
			String toDeleteTag = sc.next();
			if (toDeleteTag.equalsIgnoreCase("yes")) {
				System.out.println("Enter Tag Id To Delete");
				int tId = sc.nextInt();
				dao.deleteTag(tId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}

		case 5:
			System.out.println("Do you want to Delete Blog From database(yes/no)");
			String toDeleteBlog = sc.next();
			if (toDeleteBlog.equalsIgnoreCase("yes")) {
				System.out.println("Enter Blog Id To Delete");
				int bId = sc.nextInt();
				dao.deleteTag(bId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}

		case 6:
			System.out.println("Do you want to remove tag From blog(yes/no)");
			String toRemoveTag = sc.next();
			if (toRemoveTag.equalsIgnoreCase("yes")) {
				System.out.println("Enter Blog Id from which you want to remove tag");
				int bId = sc.nextInt();
				System.out.println("Enter Id Of a Tag Which You Want to remove");
				int tId = sc.nextInt();
				dao.removeTagFromBlog(bId, tId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 7:
			System.out.println("Enter Tag Id");
			int tId = sc.nextInt();
			dao.findTag(tId);
			runApplication();
			break;
		case 8:
			System.out.println("Enter Blog Id");
			int bId = sc.nextInt();
			dao.findBlog(bId);
			runApplication();
			break;
		case 9:
			System.out.println("All Records Are:");
			dao.findAllRecords();
			runApplication();
			break;
		case 10:
			System.out.println("Do you want to Exit (yes/no)");
			String toExit = sc.next();
			if (toExit.equalsIgnoreCase("yes")) {
				System.out.println("Thank You");
				break;
			} else {
				runApplication();
				break;
			}
		default:
			System.out.println("Enter 10 To Exit");
			runApplication();
			break;
		}
	}
}