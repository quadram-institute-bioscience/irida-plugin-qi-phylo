package ca.corefacility.bioinformatics.irida.plugins;

import java.awt.Color;
import java.util.Optional;
import java.util.UUID;

import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

import ca.corefacility.bioinformatics.irida.model.workflow.analysis.type.AnalysisType;
import ca.corefacility.bioinformatics.irida.pipeline.results.updater.AnalysisSampleUpdater;
import ca.corefacility.bioinformatics.irida.service.sample.MetadataTemplateService;
import ca.corefacility.bioinformatics.irida.service.sample.SampleService;
import ca.corefacility.bioinformatics.irida.service.workflow.IridaWorkflowsService;

/**
 * An example {@link IridaPlugin} implementation which will extract some
 * information from the sequencing reads.
 */
public class QIPhyloPlugin extends Plugin {

	/**
	 * The {@link AnalysisType} used by this plugin. This wraps around a string and
	 * is used to store the type of the analysis pipeline (which should be unique
	 * for each pipeline).
	 */
	public static final AnalysisType QI_PHYLO = new AnalysisType("QI_PHYLO");

	public QIPhyloPlugin(PluginWrapper wrapper) {
		super(wrapper);
	}

	/**
	 * This class defines information about this particular plugin. On start-up,
	 * IRIDA will make use of the information provided by this class to integrate
	 * the plugin pipeline.
	 */
	@Extension
	public static class PluginInfo implements IridaPlugin {

		/*******************************************************************************
		 * Required methods
		 * 
		 * These methods are required to be overridden when implementing a pipeline as a
		 * plugin.
		 *******************************************************************************/

		/**
		 * Gets the particular {@link AnalysisType} object for this workflow. This
		 * should correspond to the <strong>analysisType</strong> entry in the
		 * <strong>irida_workflow.xml</strong> file.
		 * 
		 * <pre>
		 * {@code <analysisType>READ_INFO</analysisType>}
		 * </pre>
		 * 
		 * @return The particular {@link AnalysisType} for this pipeline.
		 */
		@Override
		public AnalysisType getAnalysisType() {
			return QI_PHYLO;
		}

		/**
		 * Gets the particular workflow id. This should correspond to the
		 * <strong>id</strong> entry in the <strong>irida_workflow.xml</strong> file.
		 * 
		 * <pre>
		 * {@code <id>79d90ca8-00ae-441b-b5c7-193c9e85a968</id>}
		 * </pre>
		 * 
		 * @return A {@link UUID} defining the id of this pipeline.
		 */
		@Override
		public UUID getDefaultWorkflowUUID() {
			return UUID.fromString("83476350-794b-40b3-96b9-54c4ee94af59");
		}

		/*******************************************************************************
		 * Optional methods
		 * 
		 * These methods are not required to be overridden but can be used to adjust the
		 * appearance/behavior of the pipeline.
		 *******************************************************************************/

		/**
		 * Defines the background color in the IRIDA UI corresponding to this pipeline.
		 * 
		 * @return An {@link Optional} color for the background of the IRIDA UI for this
		 *         pipeline.
		 */
		@Override
		public Optional<Color> getBackgroundColor() {
			return Optional.of(Color.decode("#b7a7b2"));
		}

		/**
		 * Defines the text color in the IRIDA UI corresponding to this pipeline.
		 * 
		 * @return An {@link Optional} color for the text of the IRIDA UI for this
		 *         pipeline.
		 */
		@Override
		public Optional<Color> getTextColor() {
			return Optional.of(Color.BLACK);
		}

	}
}
