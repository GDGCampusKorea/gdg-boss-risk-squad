import { useFlow } from "@/lib/stackflow";
import { Text } from "@components/common/atoms/Text";
import AsyncBoundary from "@components/template/AsyncBoundary";
import { AppScreen } from "@stackflow/plugin-basic-ui";

export const ItemDetailPage = () => {
  const { pop } = useFlow();
  return (
    <AsyncBoundary>
      <AppScreen>
        <Text onClick={() => pop()}>뒤로 가기</Text>
      </AppScreen>
    </AsyncBoundary>
  );
};
