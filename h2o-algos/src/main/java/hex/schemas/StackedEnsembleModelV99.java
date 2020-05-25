package hex.schemas;

import hex.ensemble.StackedEnsembleModel;
import water.api.API;
import water.api.EnumValuesProvider;
import water.api.schemas3.KeyV3;
import water.api.schemas3.ModelOutputSchemaV3;
import water.api.schemas3.ModelSchemaV3;

public class StackedEnsembleModelV99 extends ModelSchemaV3<StackedEnsembleModel, StackedEnsembleModelV99, StackedEnsembleModel.StackedEnsembleParameters, StackedEnsembleV99.StackedEnsembleParametersV99, StackedEnsembleModel.StackedEnsembleOutput, StackedEnsembleModelV99.StackedEnsembleModelOutputV99> {

  public static final class StackedEnsembleModelOutputV99 extends ModelOutputSchemaV3<StackedEnsembleModel.StackedEnsembleOutput, StackedEnsembleModelOutputV99> {
    @API(help="Model which combines the base_models into a stacked ensemble.", direction = API.Direction.OUTPUT)
    KeyV3.ModelKeyV3 metalearner;

    @API(help="Level one frame used for metalearner training.", direction = API.Direction.OUTPUT)
    KeyV3.FrameKeyV3 levelone_frame_id;

    @API(help="The stacking strategy used for training.", valuesProvider = StackingStrategyProvider.class, direction = API.Direction.OUTPUT)
    StackedEnsembleModel.StackingStrategy stacking_strategy;
  }

  public static class StackingStrategyProvider extends EnumValuesProvider<StackedEnsembleModel.StackingStrategy> {
    public StackingStrategyProvider() {
      super(StackedEnsembleModel.StackingStrategy.class);
    }
  }
  
  public StackedEnsembleV99.StackedEnsembleParametersV99 createParametersSchema() { return new StackedEnsembleV99.StackedEnsembleParametersV99(); }
  public StackedEnsem´ébleModelOutputV99 createOutputSchema() { return new StackedEnsembleModelOutputV99(); }

  @Override public StackedEnsembleModel createImpl() {
    StackedEnsembleV99.StackedEnsembleParametersV99 p = this.parameters;
    StackedEnsembleModel.StackedEnsembleParameters parms = p.createImpl();
    return new StackedEnsembleModel(model_id.key(), parms, new StackedEnsembleModel.StackedEnsembleOutput());
  }

}

