import { stackflow, useActions, useStepActions } from "@stackflow/react";
import { basicRendererPlugin } from "@stackflow/plugin-renderer-basic";
import { basicUIPlugin } from "@stackflow/plugin-basic-ui";
import {
  ItemDetailPage,
  ItemUploadPage,
  ItemListPage,
  FindAlbaPage,
} from "@components/page";

const initStackflow = () => {
  return stackflow({
    transitionDuration: 350,
    activities: {
      ItemDetailPage,
      ItemUploadPage,
      ItemListPage,
      FindAlbaPage,
    },
    plugins: [
      basicRendererPlugin(),
      basicUIPlugin({
        theme: "cupertino",
      }),
    ],
    initialActivity: () => "ItemListPage",
  });
};

const {
  Stack,
  activities,
  useFlow: useOriginFlow,
  useStepFlow: useOriginStepFlow,
} = initStackflow();

export type TypeActivities = typeof activities;
export type TypeActivityNames = keyof TypeActivities;
export type TypeUseFlow = typeof useOriginFlow;
export type TypeUseStepFlow = typeof useOriginStepFlow;

const useFlow: TypeUseFlow = () => useActions<TypeActivities>();
const useStepFlow: TypeUseStepFlow = (activityName: TypeActivityNames) =>
  useStepActions(activityName as never);

export { Stack, activities, useFlow, useStepFlow };
