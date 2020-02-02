package team.yi.maven.plugin.config;

import de.skuzzle.semantic.Version;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@SuppressWarnings("PMD.TooManyFields")
public class ReleaseLogSettings implements Serializable {
    public static final String DEFAULT_MESSAGE_PATTERN = "^([\\w!]+)(\\(([\\w-$_]+)\\))?: ([^\\n]+)((\\n{1,2}([^\\n]+))*)$";
    public static final String DEFAULT_COMMIT_ISSUE_PATTERN = " \\(#(?<id>\\d+)\\)$";
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";

    private static final long serialVersionUID = -3088989076911346697L;

    private static final List<String> DEFAULT_MAJOR_TYPES = new ArrayList<>();
    private static final List<String> DEFAULT_MINOR_TYPES = Collections.singletonList("feat");
    private static final List<String> DEFAULT_PATCH_TYPES = Arrays.asList("fix", "perf", "revert", "refactor");
    private static final List<String> DEFAULT_PRE_RELEASE_TYPES = new ArrayList<>();
    private static final List<String> DEFAULT_BUILD_META_DATA_TYPES = new ArrayList<>();

    @Parameter(property = "disabled", defaultValue = "false")
    private Boolean disabled = false;

    @Parameter(property = "useCrazyGrowing", defaultValue = "true")
    private Boolean useCrazyGrowing = true;

    @Parameter(property = "lastVersion")
    private Version lastVersion;

    @Parameter(property = "preRelease")
    private String preRelease;

    @Parameter(property = "buildMetaData")
    private String buildMetaData;

    @Parameter(property = "majorTypes")
    private String majorTypes;

    @Parameter(property = "minorTypes", defaultValue = "feat")
    private String minorTypes;

    @Parameter(property = "patchTypes", defaultValue = "fix,perf,revert,refactor")
    private String patchTypes;

    @Parameter(property = "preReleaseTypes")
    private String preReleaseTypes;

    @Parameter(property = "buildMetaDataTypes")
    private String buildMetaDataTypes;

    @Parameter(property = "repoBaseUrl")
    private String repoBaseUrl;

    @Parameter(property = "commitUrlTemplate")
    private String commitUrlTemplate;

    @Parameter(property = "issueUrlTemplate")
    private String issueUrlTemplate;

    @Parameter(property = "derivedVersionMark")
    private String derivedVersionMark;

    @Parameter(property = "commitIssuePattern")
    private String commitIssuePattern;

    @Parameter(property = "quickActionPattern")
    private String quickActionPattern;

    @Parameter(property = "longDateFormat", defaultValue = LONG_DATE_FORMAT)
    private String longDateFormat = LONG_DATE_FORMAT;

    @Parameter(property = "shortDateFormat", defaultValue = SHORT_DATE_FORMAT)
    private String shortDateFormat = SHORT_DATE_FORMAT;

    public List<String> getPreReleaseTypes() {
        String[] items = StringUtils.split(this.preReleaseTypes, ",");

        return items == null || items.length == 0 ? DEFAULT_PRE_RELEASE_TYPES : Arrays.asList(items);
    }

    public List<String> getBuildMetaDataTypes() {
        String[] items = StringUtils.split(this.buildMetaDataTypes, ",");

        return items == null || items.length == 0 ? DEFAULT_BUILD_META_DATA_TYPES : Arrays.asList(items);
    }

    public List<String> getMajorTypes() {
        String[] items = StringUtils.split(this.majorTypes, ",");

        return items == null || items.length == 0 ? DEFAULT_MAJOR_TYPES : Arrays.asList(items);
    }

    public List<String> getMinorTypes() {
        String[] items = StringUtils.split(this.minorTypes, ",");

        return items == null || items.length == 0 ? DEFAULT_MINOR_TYPES : Arrays.asList(items);
    }

    public List<String> getPatchTypes() {
        String[] items = StringUtils.split(this.patchTypes, ",");

        return items == null || items.length == 0 ? DEFAULT_PATCH_TYPES : Arrays.asList(items);
    }

    public String getCommitIssuePattern() {
        return StringUtils.defaultIfBlank(this.commitIssuePattern, DEFAULT_COMMIT_ISSUE_PATTERN);
    }
}