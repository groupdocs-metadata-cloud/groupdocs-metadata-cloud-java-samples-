package examples.MetadataOperations.RemoveMetadata;

import com.groupdocs.cloud.metadata.api.MetadataApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.FileInfo;
import com.groupdocs.cloud.metadata.model.RemoveOptions;
import com.groupdocs.cloud.metadata.model.RemoveResult;
import com.groupdocs.cloud.metadata.model.SearchCriteria;
import com.groupdocs.cloud.metadata.model.Tag;
import com.groupdocs.cloud.metadata.model.TagOptions;
import com.groupdocs.cloud.metadata.model.requests.RemoveRequest;

import examples.Common;

/**
 * This example demonstrates how to remove metadata by exact tag name and tag category.
 */
public class RemoveMetadataByTag {

	public static void main(String[] args) {

		MetadataApi apiInstance = new MetadataApi(Common.GetConfiguration());

		try {
			RemoveOptions options = new RemoveOptions();
			SearchCriteria searchCriteria = new SearchCriteria();
			TagOptions tagOptions = new TagOptions();
			Tag tag = new Tag();
			tag.setName("Created");
			tag.setCategory("Time");
			tagOptions.setExactTag(tag);
			searchCriteria.setTagOptions(tagOptions);
			options.setSearchCriteria(searchCriteria);
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/input.docx");
			options.setFileInfo(fileInfo);
			RemoveRequest request = new RemoveRequest(options);

			RemoveResult response = apiInstance.remove(request);

			System.out.println("Count of changes: " + response.getRemovedCount());
			System.out.println("Resultant file path: " + response.getPath());

		} catch (ApiException e) {
			System.err.println("Exception while calling MetadataApi:");
			e.printStackTrace();
		}
	}
}